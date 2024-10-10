package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReferenceBankId;
import fpml.confirmation.validation.ReferenceBankIdTypeFormatValidator;
import fpml.confirmation.validation.ReferenceBankIdValidator;
import fpml.confirmation.validation.exists.ReferenceBankIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReferenceBankId.class)
public class ReferenceBankIdMeta implements RosettaMetaData<ReferenceBankId> {

	@Override
	public List<Validator<? super ReferenceBankId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReferenceBankId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReferenceBankId> validator() {
		return new ReferenceBankIdValidator();
	}

	@Override
	public Validator<? super ReferenceBankId> typeFormatValidator() {
		return new ReferenceBankIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferenceBankId, Set<String>> onlyExistsValidator() {
		return new ReferenceBankIdOnlyExistsValidator();
	}
}
