package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityHubCode;
import fpml.confirmation.validation.CommodityHubCodeTypeFormatValidator;
import fpml.confirmation.validation.CommodityHubCodeValidator;
import fpml.confirmation.validation.exists.CommodityHubCodeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityHubCode.class)
public class CommodityHubCodeMeta implements RosettaMetaData<CommodityHubCode> {

	@Override
	public List<Validator<? super CommodityHubCode>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityHubCode, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityHubCode> validator() {
		return new CommodityHubCodeValidator();
	}

	@Override
	public Validator<? super CommodityHubCode> typeFormatValidator() {
		return new CommodityHubCodeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityHubCode, Set<String>> onlyExistsValidator() {
		return new CommodityHubCodeOnlyExistsValidator();
	}
}
