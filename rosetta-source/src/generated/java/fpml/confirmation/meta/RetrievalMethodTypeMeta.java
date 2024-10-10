package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RetrievalMethodType;
import fpml.confirmation.validation.RetrievalMethodTypeTypeFormatValidator;
import fpml.confirmation.validation.RetrievalMethodTypeValidator;
import fpml.confirmation.validation.exists.RetrievalMethodTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RetrievalMethodType.class)
public class RetrievalMethodTypeMeta implements RosettaMetaData<RetrievalMethodType> {

	@Override
	public List<Validator<? super RetrievalMethodType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RetrievalMethodType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RetrievalMethodType> validator() {
		return new RetrievalMethodTypeValidator();
	}

	@Override
	public Validator<? super RetrievalMethodType> typeFormatValidator() {
		return new RetrievalMethodTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RetrievalMethodType, Set<String>> onlyExistsValidator() {
		return new RetrievalMethodTypeOnlyExistsValidator();
	}
}
