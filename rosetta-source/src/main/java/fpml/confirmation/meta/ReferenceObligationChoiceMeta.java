package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReferenceObligationChoice;
import fpml.confirmation.validation.ReferenceObligationChoiceTypeFormatValidator;
import fpml.confirmation.validation.ReferenceObligationChoiceValidator;
import fpml.confirmation.validation.exists.ReferenceObligationChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReferenceObligationChoice.class)
public class ReferenceObligationChoiceMeta implements RosettaMetaData<ReferenceObligationChoice> {

	@Override
	public List<Validator<? super ReferenceObligationChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ReferenceObligationChoice>create(fpml.confirmation.validation.datarule.ReferenceObligationChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ReferenceObligationChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReferenceObligationChoice> validator() {
		return new ReferenceObligationChoiceValidator();
	}

	@Override
	public Validator<? super ReferenceObligationChoice> typeFormatValidator() {
		return new ReferenceObligationChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferenceObligationChoice, Set<String>> onlyExistsValidator() {
		return new ReferenceObligationChoiceOnlyExistsValidator();
	}
}
