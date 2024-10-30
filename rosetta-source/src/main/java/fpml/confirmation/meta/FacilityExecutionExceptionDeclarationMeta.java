package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityExecutionExceptionDeclaration;
import fpml.confirmation.validation.FacilityExecutionExceptionDeclarationTypeFormatValidator;
import fpml.confirmation.validation.FacilityExecutionExceptionDeclarationValidator;
import fpml.confirmation.validation.exists.FacilityExecutionExceptionDeclarationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FacilityExecutionExceptionDeclaration.class)
public class FacilityExecutionExceptionDeclarationMeta implements RosettaMetaData<FacilityExecutionExceptionDeclaration> {

	@Override
	public List<Validator<? super FacilityExecutionExceptionDeclaration>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityExecutionExceptionDeclaration, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityExecutionExceptionDeclaration> validator() {
		return new FacilityExecutionExceptionDeclarationValidator();
	}

	@Override
	public Validator<? super FacilityExecutionExceptionDeclaration> typeFormatValidator() {
		return new FacilityExecutionExceptionDeclarationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityExecutionExceptionDeclaration, Set<String>> onlyExistsValidator() {
		return new FacilityExecutionExceptionDeclarationOnlyExistsValidator();
	}
}
