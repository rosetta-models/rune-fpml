package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ApplicableTransactionType;
import fpml.confirmation.validation.ApplicableTransactionTypeTypeFormatValidator;
import fpml.confirmation.validation.ApplicableTransactionTypeValidator;
import fpml.confirmation.validation.exists.ApplicableTransactionTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ApplicableTransactionType.class)
public class ApplicableTransactionTypeMeta implements RosettaMetaData<ApplicableTransactionType> {

	@Override
	public List<Validator<? super ApplicableTransactionType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ApplicableTransactionType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ApplicableTransactionType> validator() {
		return new ApplicableTransactionTypeValidator();
	}

	@Override
	public Validator<? super ApplicableTransactionType> typeFormatValidator() {
		return new ApplicableTransactionTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApplicableTransactionType, Set<String>> onlyExistsValidator() {
		return new ApplicableTransactionTypeOnlyExistsValidator();
	}
}
