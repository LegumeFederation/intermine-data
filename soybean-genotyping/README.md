# Soybean Genotyping Experiment

The genotyping data file is found on the LIS datastore, in Flapjack format. Here we simply prepend some metadata for the loader:

TaxonID	3847
GenotypingStudy	BARC_1059007
Description	The entire U.S. germplasm collection genotyped with the SoySNP50K iSelect BeadChip.
MatrixNotes	Heterozygous alleles are shown with slash notation.
MarkerType	SNP
PMID	26224783
Markers	ss715578788	ss715578818	ss715578923	ss715578960	ss715579193	ss715579265	ss715579576	ss715579942	ss715580755	ss715580822	ss715580828	ss715580853	ss715580

If the data header starts with "Markers", as above, then the header line lists the genetic markers and each row starts with the name of the genotyping line.

If the data header starts with "Lines", then the header line lists the genotyping lines and each row starts with the name of the genetic marker.
