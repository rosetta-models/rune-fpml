package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityInterestLeg;
import fpml.confirmation.validation.CommodityInterestLegTypeFormatValidator;
import fpml.confirmation.validation.CommodityInterestLegValidator;
import fpml.confirmation.validation.exists.CommodityInterestLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityInterestLeg.class)
public class CommodityInterestLegMeta implements RosettaMetaData<CommodityInterestLeg> {

	@Override
	public List<Validator<? super CommodityInterestLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityInterestLeg>create(fpml.confirmation.validation.datarule.CommodityInterestLegChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityInterestLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityInterestLeg> validator() {
		return new CommodityInterestLegValidator();
	}

	@Override
	public Validator<? super CommodityInterestLeg> typeFormatValidator() {
		return new CommodityInterestLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityInterestLeg, Set<String>> onlyExistsValidator() {
		return new CommodityInterestLegOnlyExistsValidator();
	}
}
