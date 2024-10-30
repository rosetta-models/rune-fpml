package fpml.enumeration.mapping.functions;

import cdm.base.datetime.BusinessCenterEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapBusinessCenterEnum.MapBusinessCenterEnumDefault.class)
public abstract class MapBusinessCenterEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public BusinessCenterEnum evaluate(String value) {
		BusinessCenterEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract BusinessCenterEnum doEvaluate(String value);

	public static class MapBusinessCenterEnumDefault extends MapBusinessCenterEnum {
		@Override
		protected BusinessCenterEnum doEvaluate(String value) {
			BusinessCenterEnum result = null;
			return assignOutput(result, value);
		}
		
		protected BusinessCenterEnum assignOutput(BusinessCenterEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("AEAB"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.AEAB;
			} else if (areEqual(switchArgument, MapperS.of("AEAD"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.AEAD;
			} else if (areEqual(switchArgument, MapperS.of("AEDU"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.AEDU;
			} else if (areEqual(switchArgument, MapperS.of("AMYE"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.AMYE;
			} else if (areEqual(switchArgument, MapperS.of("AOLU"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.AOLU;
			} else if (areEqual(switchArgument, MapperS.of("ARBA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.ARBA;
			} else if (areEqual(switchArgument, MapperS.of("ATVI"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.ATVI;
			} else if (areEqual(switchArgument, MapperS.of("AUAD"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.AUAD;
			} else if (areEqual(switchArgument, MapperS.of("AUBR"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.AUBR;
			} else if (areEqual(switchArgument, MapperS.of("AUCA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.AUCA;
			} else if (areEqual(switchArgument, MapperS.of("AUDA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.AUDA;
			} else if (areEqual(switchArgument, MapperS.of("AUME"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.AUME;
			} else if (areEqual(switchArgument, MapperS.of("AUPE"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.AUPE;
			} else if (areEqual(switchArgument, MapperS.of("AUSY"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.AUSY;
			} else if (areEqual(switchArgument, MapperS.of("BBBR"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.BBBR;
			} else if (areEqual(switchArgument, MapperS.of("BDDH"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.BDDH;
			} else if (areEqual(switchArgument, MapperS.of("BEBR"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.BEBR;
			} else if (areEqual(switchArgument, MapperS.of("BGSO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.BGSO;
			} else if (areEqual(switchArgument, MapperS.of("BHMA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.BHMA;
			} else if (areEqual(switchArgument, MapperS.of("BMHA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.BMHA;
			} else if (areEqual(switchArgument, MapperS.of("BNBS"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.BNBS;
			} else if (areEqual(switchArgument, MapperS.of("BOLP"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.BOLP;
			} else if (areEqual(switchArgument, MapperS.of("BRBD"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.BRBD;
			} else if (areEqual(switchArgument, MapperS.of("BRBR"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.BRBR;
			} else if (areEqual(switchArgument, MapperS.of("BRRJ"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.BRRJ;
			} else if (areEqual(switchArgument, MapperS.of("BRSP"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.BRSP;
			} else if (areEqual(switchArgument, MapperS.of("BSNA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.BSNA;
			} else if (areEqual(switchArgument, MapperS.of("BWGA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.BWGA;
			} else if (areEqual(switchArgument, MapperS.of("BYMI"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.BYMI;
			} else if (areEqual(switchArgument, MapperS.of("CACL"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.CACL;
			} else if (areEqual(switchArgument, MapperS.of("CAMO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.CAMO;
			} else if (areEqual(switchArgument, MapperS.of("CAOT"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.CAOT;
			} else if (areEqual(switchArgument, MapperS.of("CATO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.CATO;
			} else if (areEqual(switchArgument, MapperS.of("CAVA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.CAVA;
			} else if (areEqual(switchArgument, MapperS.of("CAWI"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.CAWI;
			} else if (areEqual(switchArgument, MapperS.of("CHBA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.CHBA;
			} else if (areEqual(switchArgument, MapperS.of("CHGE"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.CHGE;
			} else if (areEqual(switchArgument, MapperS.of("CHZU"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.CHZU;
			} else if (areEqual(switchArgument, MapperS.of("CIAB"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.CIAB;
			} else if (areEqual(switchArgument, MapperS.of("CLSA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.CLSA;
			} else if (areEqual(switchArgument, MapperS.of("CMYA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.CMYA;
			} else if (areEqual(switchArgument, MapperS.of("CNBE"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.CNBE;
			} else if (areEqual(switchArgument, MapperS.of("CNSH"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.CNSH;
			} else if (areEqual(switchArgument, MapperS.of("COBO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.COBO;
			} else if (areEqual(switchArgument, MapperS.of("CRSJ"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.CRSJ;
			} else if (areEqual(switchArgument, MapperS.of("CWWI"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.CWWI;
			} else if (areEqual(switchArgument, MapperS.of("CYNI"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.CYNI;
			} else if (areEqual(switchArgument, MapperS.of("CZPR"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.CZPR;
			} else if (areEqual(switchArgument, MapperS.of("DECO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.DECO;
			} else if (areEqual(switchArgument, MapperS.of("DEDU"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.DEDU;
			} else if (areEqual(switchArgument, MapperS.of("DEFR"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.DEFR;
			} else if (areEqual(switchArgument, MapperS.of("DEHH"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.DEHH;
			} else if (areEqual(switchArgument, MapperS.of("DELE"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.DELE;
			} else if (areEqual(switchArgument, MapperS.of("DEMA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.DEMA;
			} else if (areEqual(switchArgument, MapperS.of("DEMU"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.DEMU;
			} else if (areEqual(switchArgument, MapperS.of("DEST"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.DEST;
			} else if (areEqual(switchArgument, MapperS.of("DKCO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.DKCO;
			} else if (areEqual(switchArgument, MapperS.of("DOSD"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.DOSD;
			} else if (areEqual(switchArgument, MapperS.of("DZAL"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.DZAL;
			} else if (areEqual(switchArgument, MapperS.of("ECGU"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.ECGU;
			} else if (areEqual(switchArgument, MapperS.of("EETA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.EETA;
			} else if (areEqual(switchArgument, MapperS.of("EGCA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.EGCA;
			} else if (areEqual(switchArgument, MapperS.of("ESAS"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.ESAS;
			} else if (areEqual(switchArgument, MapperS.of("ESBA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.ESBA;
			} else if (areEqual(switchArgument, MapperS.of("ESMA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.ESMA;
			} else if (areEqual(switchArgument, MapperS.of("ESSS"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.ESSS;
			} else if (areEqual(switchArgument, MapperS.of("ETAA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.ETAA;
			} else if (areEqual(switchArgument, MapperS.of("EUR-ICESWAP"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.EUR_ICESWAP;
			} else if (areEqual(switchArgument, MapperS.of("EUTA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.EUTA;
			} else if (areEqual(switchArgument, MapperS.of("FIHE"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.FIHE;
			} else if (areEqual(switchArgument, MapperS.of("FRPA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.FRPA;
			} else if (areEqual(switchArgument, MapperS.of("GBED"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.GBED;
			} else if (areEqual(switchArgument, MapperS.of("GBLO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.GBLO;
			} else if (areEqual(switchArgument, MapperS.of("GBP-ICESWAP"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.GBP_ICESWAP;
			} else if (areEqual(switchArgument, MapperS.of("GETB"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.GETB;
			} else if (areEqual(switchArgument, MapperS.of("GGSP"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.GGSP;
			} else if (areEqual(switchArgument, MapperS.of("GHAC"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.GHAC;
			} else if (areEqual(switchArgument, MapperS.of("GIGI"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.GIGI;
			} else if (areEqual(switchArgument, MapperS.of("GMBA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.GMBA;
			} else if (areEqual(switchArgument, MapperS.of("GNCO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.GNCO;
			} else if (areEqual(switchArgument, MapperS.of("GRAT"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.GRAT;
			} else if (areEqual(switchArgument, MapperS.of("GTGC"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.GTGC;
			} else if (areEqual(switchArgument, MapperS.of("HKHK"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.HKHK;
			} else if (areEqual(switchArgument, MapperS.of("HNTE"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.HNTE;
			} else if (areEqual(switchArgument, MapperS.of("HRZA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.HRZA;
			} else if (areEqual(switchArgument, MapperS.of("HUBU"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.HUBU;
			} else if (areEqual(switchArgument, MapperS.of("IDJA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.IDJA;
			} else if (areEqual(switchArgument, MapperS.of("IEDU"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.IEDU;
			} else if (areEqual(switchArgument, MapperS.of("ILJE"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.ILJE;
			} else if (areEqual(switchArgument, MapperS.of("ILS-TELBOR"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.ILS_TELBOR;
			} else if (areEqual(switchArgument, MapperS.of("ILTA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.ILTA;
			} else if (areEqual(switchArgument, MapperS.of("INAH"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.INAH;
			} else if (areEqual(switchArgument, MapperS.of("INBA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.INBA;
			} else if (areEqual(switchArgument, MapperS.of("INCH"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.INCH;
			} else if (areEqual(switchArgument, MapperS.of("INHY"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.INHY;
			} else if (areEqual(switchArgument, MapperS.of("INKO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.INKO;
			} else if (areEqual(switchArgument, MapperS.of("INMU"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.INMU;
			} else if (areEqual(switchArgument, MapperS.of("INND"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.INND;
			} else if (areEqual(switchArgument, MapperS.of("IQBA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.IQBA;
			} else if (areEqual(switchArgument, MapperS.of("IRTE"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.IRTE;
			} else if (areEqual(switchArgument, MapperS.of("ISRE"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.ISRE;
			} else if (areEqual(switchArgument, MapperS.of("ITMI"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.ITMI;
			} else if (areEqual(switchArgument, MapperS.of("ITRO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.ITRO;
			} else if (areEqual(switchArgument, MapperS.of("ITTU"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.ITTU;
			} else if (areEqual(switchArgument, MapperS.of("JESH"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.JESH;
			} else if (areEqual(switchArgument, MapperS.of("JMKI"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.JMKI;
			} else if (areEqual(switchArgument, MapperS.of("JOAM"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.JOAM;
			} else if (areEqual(switchArgument, MapperS.of("JPTO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.JPTO;
			} else if (areEqual(switchArgument, MapperS.of("KENA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.KENA;
			} else if (areEqual(switchArgument, MapperS.of("KRSE"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.KRSE;
			} else if (areEqual(switchArgument, MapperS.of("KWKC"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.KWKC;
			} else if (areEqual(switchArgument, MapperS.of("KYGE"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.KYGE;
			} else if (areEqual(switchArgument, MapperS.of("KZAL"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.KZAL;
			} else if (areEqual(switchArgument, MapperS.of("LAVI"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.LAVI;
			} else if (areEqual(switchArgument, MapperS.of("LBBE"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.LBBE;
			} else if (areEqual(switchArgument, MapperS.of("LKCO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.LKCO;
			} else if (areEqual(switchArgument, MapperS.of("LULU"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.LULU;
			} else if (areEqual(switchArgument, MapperS.of("LVRI"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.LVRI;
			} else if (areEqual(switchArgument, MapperS.of("MACA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.MACA;
			} else if (areEqual(switchArgument, MapperS.of("MARA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.MARA;
			} else if (areEqual(switchArgument, MapperS.of("MCMO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.MCMO;
			} else if (areEqual(switchArgument, MapperS.of("MNUB"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.MNUB;
			} else if (areEqual(switchArgument, MapperS.of("MOMA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.MOMA;
			} else if (areEqual(switchArgument, MapperS.of("MTVA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.MTVA;
			} else if (areEqual(switchArgument, MapperS.of("MUPL"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.MUPL;
			} else if (areEqual(switchArgument, MapperS.of("MVMA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.MVMA;
			} else if (areEqual(switchArgument, MapperS.of("MWLI"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.MWLI;
			} else if (areEqual(switchArgument, MapperS.of("MXMC"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.MXMC;
			} else if (areEqual(switchArgument, MapperS.of("MYKL"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.MYKL;
			} else if (areEqual(switchArgument, MapperS.of("MYLA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.MYLA;
			} else if (areEqual(switchArgument, MapperS.of("MZMA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.MZMA;
			} else if (areEqual(switchArgument, MapperS.of("NAWI"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.NAWI;
			} else if (areEqual(switchArgument, MapperS.of("NGAB"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.NGAB;
			} else if (areEqual(switchArgument, MapperS.of("NGLA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.NGLA;
			} else if (areEqual(switchArgument, MapperS.of("NLAM"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.NLAM;
			} else if (areEqual(switchArgument, MapperS.of("NLRO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.NLRO;
			} else if (areEqual(switchArgument, MapperS.of("NOOS"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.NOOS;
			} else if (areEqual(switchArgument, MapperS.of("NPKA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.NPKA;
			} else if (areEqual(switchArgument, MapperS.of("NYFD"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.NYFD;
			} else if (areEqual(switchArgument, MapperS.of("NYSE"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.NYSE;
			} else if (areEqual(switchArgument, MapperS.of("NZAU"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.NZAU;
			} else if (areEqual(switchArgument, MapperS.of("NZWE"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.NZWE;
			} else if (areEqual(switchArgument, MapperS.of("OMMU"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.OMMU;
			} else if (areEqual(switchArgument, MapperS.of("PAPC"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.PAPC;
			} else if (areEqual(switchArgument, MapperS.of("PELI"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.PELI;
			} else if (areEqual(switchArgument, MapperS.of("PHMA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.PHMA;
			} else if (areEqual(switchArgument, MapperS.of("PHMK"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.PHMK;
			} else if (areEqual(switchArgument, MapperS.of("PKKA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.PKKA;
			} else if (areEqual(switchArgument, MapperS.of("PLWA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.PLWA;
			} else if (areEqual(switchArgument, MapperS.of("PRSJ"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.PRSJ;
			} else if (areEqual(switchArgument, MapperS.of("PTLI"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.PTLI;
			} else if (areEqual(switchArgument, MapperS.of("QADO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.QADO;
			} else if (areEqual(switchArgument, MapperS.of("ROBU"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.ROBU;
			} else if (areEqual(switchArgument, MapperS.of("RSBE"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.RSBE;
			} else if (areEqual(switchArgument, MapperS.of("RUMO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.RUMO;
			} else if (areEqual(switchArgument, MapperS.of("SAAB"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.SAAB;
			} else if (areEqual(switchArgument, MapperS.of("SAJE"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.SAJE;
			} else if (areEqual(switchArgument, MapperS.of("SARI"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.SARI;
			} else if (areEqual(switchArgument, MapperS.of("SEST"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.SEST;
			} else if (areEqual(switchArgument, MapperS.of("SGSI"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.SGSI;
			} else if (areEqual(switchArgument, MapperS.of("SILJ"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.SILJ;
			} else if (areEqual(switchArgument, MapperS.of("SKBR"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.SKBR;
			} else if (areEqual(switchArgument, MapperS.of("SLFR"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.SLFR;
			} else if (areEqual(switchArgument, MapperS.of("SNDA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.SNDA;
			} else if (areEqual(switchArgument, MapperS.of("SVSS"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.SVSS;
			} else if (areEqual(switchArgument, MapperS.of("THBA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.THBA;
			} else if (areEqual(switchArgument, MapperS.of("TNTU"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.TNTU;
			} else if (areEqual(switchArgument, MapperS.of("TRAN"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.TRAN;
			} else if (areEqual(switchArgument, MapperS.of("TRIS"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.TRIS;
			} else if (areEqual(switchArgument, MapperS.of("TTPS"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.TTPS;
			} else if (areEqual(switchArgument, MapperS.of("TWTA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.TWTA;
			} else if (areEqual(switchArgument, MapperS.of("TZDA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.TZDA;
			} else if (areEqual(switchArgument, MapperS.of("TZDO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.TZDO;
			} else if (areEqual(switchArgument, MapperS.of("UAKI"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.UAKI;
			} else if (areEqual(switchArgument, MapperS.of("UGKA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.UGKA;
			} else if (areEqual(switchArgument, MapperS.of("USBO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USBO;
			} else if (areEqual(switchArgument, MapperS.of("USCH"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USCH;
			} else if (areEqual(switchArgument, MapperS.of("USCR"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USCR;
			} else if (areEqual(switchArgument, MapperS.of("USD-ICESWAP"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USD_ICESWAP;
			} else if (areEqual(switchArgument, MapperS.of("USD-MUNI"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USD_MUNI;
			} else if (areEqual(switchArgument, MapperS.of("USDC"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USDC;
			} else if (areEqual(switchArgument, MapperS.of("USDN"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USDN;
			} else if (areEqual(switchArgument, MapperS.of("USDT"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USDT;
			} else if (areEqual(switchArgument, MapperS.of("USGS"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USGS;
			} else if (areEqual(switchArgument, MapperS.of("USHL"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USHL;
			} else if (areEqual(switchArgument, MapperS.of("USHO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USHO;
			} else if (areEqual(switchArgument, MapperS.of("USLA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USLA;
			} else if (areEqual(switchArgument, MapperS.of("USMB"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USMB;
			} else if (areEqual(switchArgument, MapperS.of("USMN"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USMN;
			} else if (areEqual(switchArgument, MapperS.of("USNY"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USNY;
			} else if (areEqual(switchArgument, MapperS.of("USPO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USPO;
			} else if (areEqual(switchArgument, MapperS.of("USSA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USSA;
			} else if (areEqual(switchArgument, MapperS.of("USSE"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USSE;
			} else if (areEqual(switchArgument, MapperS.of("USSF"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USSF;
			} else if (areEqual(switchArgument, MapperS.of("USWT"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.USWT;
			} else if (areEqual(switchArgument, MapperS.of("UYMO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.UYMO;
			} else if (areEqual(switchArgument, MapperS.of("UZTA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.UZTA;
			} else if (areEqual(switchArgument, MapperS.of("VECA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.VECA;
			} else if (areEqual(switchArgument, MapperS.of("VGRT"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.VGRT;
			} else if (areEqual(switchArgument, MapperS.of("VNHA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.VNHA;
			} else if (areEqual(switchArgument, MapperS.of("VNHC"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.VNHC;
			} else if (areEqual(switchArgument, MapperS.of("YEAD"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.YEAD;
			} else if (areEqual(switchArgument, MapperS.of("ZAJO"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.ZAJO;
			} else if (areEqual(switchArgument, MapperS.of("ZMLU"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.ZMLU;
			} else if (areEqual(switchArgument, MapperS.of("ZWHA"), CardinalityOperator.All).get()) {
				result = BusinessCenterEnum.ZWHA;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
