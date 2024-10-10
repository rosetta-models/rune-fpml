package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommoditySwap;
import fpml.confirmation.validation.CommoditySwapTypeFormatValidator;
import fpml.confirmation.validation.CommoditySwapValidator;
import fpml.confirmation.validation.exists.CommoditySwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommoditySwap.class)
public class CommoditySwapMeta implements RosettaMetaData<CommoditySwap> {

	@Override
	public List<Validator<? super CommoditySwap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommoditySwap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommoditySwap> validator() {
		return new CommoditySwapValidator();
	}

	@Override
	public Validator<? super CommoditySwap> typeFormatValidator() {
		return new CommoditySwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommoditySwap, Set<String>> onlyExistsValidator() {
		return new CommoditySwapOnlyExistsValidator();
	}
}
