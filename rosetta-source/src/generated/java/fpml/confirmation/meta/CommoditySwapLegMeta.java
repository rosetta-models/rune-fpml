package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommoditySwapLeg;
import fpml.confirmation.validation.CommoditySwapLegTypeFormatValidator;
import fpml.confirmation.validation.CommoditySwapLegValidator;
import fpml.confirmation.validation.exists.CommoditySwapLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommoditySwapLeg.class)
public class CommoditySwapLegMeta implements RosettaMetaData<CommoditySwapLeg> {

	@Override
	public List<Validator<? super CommoditySwapLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommoditySwapLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommoditySwapLeg> validator() {
		return new CommoditySwapLegValidator();
	}

	@Override
	public Validator<? super CommoditySwapLeg> typeFormatValidator() {
		return new CommoditySwapLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommoditySwapLeg, Set<String>> onlyExistsValidator() {
		return new CommoditySwapLegOnlyExistsValidator();
	}
}
