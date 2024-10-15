package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityPositionStatement;
import fpml.confirmation.validation.FacilityPositionStatementTypeFormatValidator;
import fpml.confirmation.validation.FacilityPositionStatementValidator;
import fpml.confirmation.validation.exists.FacilityPositionStatementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityPositionStatement.class)
public class FacilityPositionStatementMeta implements RosettaMetaData<FacilityPositionStatement> {

	@Override
	public List<Validator<? super FacilityPositionStatement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityPositionStatement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityPositionStatement> validator() {
		return new FacilityPositionStatementValidator();
	}

	@Override
	public Validator<? super FacilityPositionStatement> typeFormatValidator() {
		return new FacilityPositionStatementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityPositionStatement, Set<String>> onlyExistsValidator() {
		return new FacilityPositionStatementOnlyExistsValidator();
	}
}
