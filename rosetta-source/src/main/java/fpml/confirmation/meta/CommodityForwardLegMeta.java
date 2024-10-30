package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityForwardLeg;
import fpml.confirmation.validation.CommodityForwardLegTypeFormatValidator;
import fpml.confirmation.validation.CommodityForwardLegValidator;
import fpml.confirmation.validation.exists.CommodityForwardLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityForwardLeg.class)
public class CommodityForwardLegMeta implements RosettaMetaData<CommodityForwardLeg> {

	@Override
	public List<Validator<? super CommodityForwardLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityForwardLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityForwardLeg> validator() {
		return new CommodityForwardLegValidator();
	}

	@Override
	public Validator<? super CommodityForwardLeg> typeFormatValidator() {
		return new CommodityForwardLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityForwardLeg, Set<String>> onlyExistsValidator() {
		return new CommodityForwardLegOnlyExistsValidator();
	}
}
