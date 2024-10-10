package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.VolatilityRepresentation;
import fpml.confirmation.validation.VolatilityRepresentationTypeFormatValidator;
import fpml.confirmation.validation.VolatilityRepresentationValidator;
import fpml.confirmation.validation.exists.VolatilityRepresentationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=VolatilityRepresentation.class)
public class VolatilityRepresentationMeta implements RosettaMetaData<VolatilityRepresentation> {

	@Override
	public List<Validator<? super VolatilityRepresentation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VolatilityRepresentation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VolatilityRepresentation> validator() {
		return new VolatilityRepresentationValidator();
	}

	@Override
	public Validator<? super VolatilityRepresentation> typeFormatValidator() {
		return new VolatilityRepresentationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VolatilityRepresentation, Set<String>> onlyExistsValidator() {
		return new VolatilityRepresentationOnlyExistsValidator();
	}
}
