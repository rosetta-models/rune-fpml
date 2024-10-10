package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Documentation;
import fpml.confirmation.validation.DocumentationTypeFormatValidator;
import fpml.confirmation.validation.DocumentationValidator;
import fpml.confirmation.validation.exists.DocumentationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Documentation.class)
public class DocumentationMeta implements RosettaMetaData<Documentation> {

	@Override
	public List<Validator<? super Documentation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.Documentation>create(fpml.confirmation.validation.datarule.DocumentationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Documentation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Documentation> validator() {
		return new DocumentationValidator();
	}

	@Override
	public Validator<? super Documentation> typeFormatValidator() {
		return new DocumentationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Documentation, Set<String>> onlyExistsValidator() {
		return new DocumentationOnlyExistsValidator();
	}
}
