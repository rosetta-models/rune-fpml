package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AssetClass;
import fpml.confirmation.validation.AssetClassTypeFormatValidator;
import fpml.confirmation.validation.AssetClassValidator;
import fpml.confirmation.validation.exists.AssetClassOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AssetClass.class)
public class AssetClassMeta implements RosettaMetaData<AssetClass> {

	@Override
	public List<Validator<? super AssetClass>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssetClass, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AssetClass> validator() {
		return new AssetClassValidator();
	}

	@Override
	public Validator<? super AssetClass> typeFormatValidator() {
		return new AssetClassTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetClass, Set<String>> onlyExistsValidator() {
		return new AssetClassOnlyExistsValidator();
	}
}
