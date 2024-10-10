package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityMetalBrandName;
import fpml.confirmation.validation.CommodityMetalBrandNameTypeFormatValidator;
import fpml.confirmation.validation.CommodityMetalBrandNameValidator;
import fpml.confirmation.validation.exists.CommodityMetalBrandNameOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityMetalBrandName.class)
public class CommodityMetalBrandNameMeta implements RosettaMetaData<CommodityMetalBrandName> {

	@Override
	public List<Validator<? super CommodityMetalBrandName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityMetalBrandName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityMetalBrandName> validator() {
		return new CommodityMetalBrandNameValidator();
	}

	@Override
	public Validator<? super CommodityMetalBrandName> typeFormatValidator() {
		return new CommodityMetalBrandNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityMetalBrandName, Set<String>> onlyExistsValidator() {
		return new CommodityMetalBrandNameOnlyExistsValidator();
	}
}
