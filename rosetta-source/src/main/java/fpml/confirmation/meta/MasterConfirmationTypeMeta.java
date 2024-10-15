package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MasterConfirmationType;
import fpml.confirmation.validation.MasterConfirmationTypeTypeFormatValidator;
import fpml.confirmation.validation.MasterConfirmationTypeValidator;
import fpml.confirmation.validation.exists.MasterConfirmationTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MasterConfirmationType.class)
public class MasterConfirmationTypeMeta implements RosettaMetaData<MasterConfirmationType> {

	@Override
	public List<Validator<? super MasterConfirmationType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MasterConfirmationType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MasterConfirmationType> validator() {
		return new MasterConfirmationTypeValidator();
	}

	@Override
	public Validator<? super MasterConfirmationType> typeFormatValidator() {
		return new MasterConfirmationTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MasterConfirmationType, Set<String>> onlyExistsValidator() {
		return new MasterConfirmationTypeOnlyExistsValidator();
	}
}
