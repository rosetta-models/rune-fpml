package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityStatement;
import fpml.confirmation.validation.FacilityStatementTypeFormatValidator;
import fpml.confirmation.validation.FacilityStatementValidator;
import fpml.confirmation.validation.exists.FacilityStatementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityStatement.class)
public class FacilityStatementMeta implements RosettaMetaData<FacilityStatement> {

	@Override
	public List<Validator<? super FacilityStatement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityStatement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityStatement> validator() {
		return new FacilityStatementValidator();
	}

	@Override
	public Validator<? super FacilityStatement> typeFormatValidator() {
		return new FacilityStatementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityStatement, Set<String>> onlyExistsValidator() {
		return new FacilityStatementOnlyExistsValidator();
	}
}
