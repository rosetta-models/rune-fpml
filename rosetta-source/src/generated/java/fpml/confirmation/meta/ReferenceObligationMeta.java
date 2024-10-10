package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReferenceObligation;
import fpml.confirmation.validation.ReferenceObligationTypeFormatValidator;
import fpml.confirmation.validation.ReferenceObligationValidator;
import fpml.confirmation.validation.exists.ReferenceObligationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReferenceObligation.class)
public class ReferenceObligationMeta implements RosettaMetaData<ReferenceObligation> {

	@Override
	public List<Validator<? super ReferenceObligation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ReferenceObligation>create(fpml.confirmation.validation.datarule.ReferenceObligationChoice0.class),
			factory.<fpml.confirmation.ReferenceObligation>create(fpml.confirmation.validation.datarule.ReferenceObligationChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super ReferenceObligation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReferenceObligation> validator() {
		return new ReferenceObligationValidator();
	}

	@Override
	public Validator<? super ReferenceObligation> typeFormatValidator() {
		return new ReferenceObligationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferenceObligation, Set<String>> onlyExistsValidator() {
		return new ReferenceObligationOnlyExistsValidator();
	}
}
