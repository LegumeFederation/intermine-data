#!/usr/bin/python
#
# Create a two-column map from v1 gene IDs to v2 gene IDs from the Phytozome v2 GFF

import sys
import datetime

if len(sys.argv)!=2:
    print "make-id-map.py <GFF3 file>"
    sys.exit(0)

filename = sys.argv[1]

f = open(filename, 'rU')

for line in f:
    if line[0]!='#':
        chunks = line.split('\t')
        seq = chunks[0]
        source = chunks[1]
        feature = chunks[2]
        start = int(chunks[3])
        end = int(chunks[4])
        score = chunks[5]
        strand = chunks[6]
        phase = chunks[7]
        attributes = chunks[8]
        if feature=='gene':
            pieces = attributes.split(';')
            for piece in pieces:
                parts = piece.split('=')
                if parts[0]=='ID':
                    v2name = parts[1]
                if parts[0]=='ancestorIdentifier':
                    v1name = parts[1]
            print v2name+'\t'+v1name,

f.close()
