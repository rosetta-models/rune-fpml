package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityVarianceLeg;
import fpml.confirmation.validation.CommodityVarianceLegTypeFormatValidator;
import fpml.confirmation.validation.CommodityVarianceLegValidator;
import fpml.confirmation.validation.exists.CommodityVarianceLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityVarianceLeg.class)
public class CommodityVarianceLegMeta implements RosettaMetaData<CommodityVarianceLeg> {

	@Override
	public List<Validator<? super CommodityVarianceLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityVarianceLeg>create(fpml.confirmation.validation.datarule.CommodityVarianceLegChoice.class),
			factory.<fpml.confirmation.CommodityVarianceLeg>create(fpml.confirmation.validation.datarule.CommodityVarianceLegChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityVarianceLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityVarianceLeg> validator() {
		return new CommodityVarianceLegValidator();
	}

	@Override
	public Validator<? super CommodityVarianceLeg> typeFormatValidator() {
		return new CommodityVarianceLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityVarianceLeg, Set<String>> onlyExistsValidator() {
		return new CommodityVarianceLegOnlyExistsValidator();
	}
}
