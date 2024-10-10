package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DataProvider;
import fpml.confirmation.validation.DataProviderTypeFormatValidator;
import fpml.confirmation.validation.DataProviderValidator;
import fpml.confirmation.validation.exists.DataProviderOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DataProvider.class)
public class DataProviderMeta implements RosettaMetaData<DataProvider> {

	@Override
	public List<Validator<? super DataProvider>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DataProvider, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DataProvider> validator() {
		return new DataProviderValidator();
	}

	@Override
	public Validator<? super DataProvider> typeFormatValidator() {
		return new DataProviderTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DataProvider, Set<String>> onlyExistsValidator() {
		return new DataProviderOnlyExistsValidator();
	}
}
