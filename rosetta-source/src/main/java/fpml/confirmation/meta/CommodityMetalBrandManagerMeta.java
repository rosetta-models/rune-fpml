package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityMetalBrandManager;
import fpml.confirmation.validation.CommodityMetalBrandManagerTypeFormatValidator;
import fpml.confirmation.validation.CommodityMetalBrandManagerValidator;
import fpml.confirmation.validation.exists.CommodityMetalBrandManagerOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityMetalBrandManager.class)
public class CommodityMetalBrandManagerMeta implements RosettaMetaData<CommodityMetalBrandManager> {

	@Override
	public List<Validator<? super CommodityMetalBrandManager>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityMetalBrandManager, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityMetalBrandManager> validator() {
		return new CommodityMetalBrandManagerValidator();
	}

	@Override
	public Validator<? super CommodityMetalBrandManager> typeFormatValidator() {
		return new CommodityMetalBrandManagerTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityMetalBrandManager, Set<String>> onlyExistsValidator() {
		return new CommodityMetalBrandManagerOnlyExistsValidator();
	}
}
