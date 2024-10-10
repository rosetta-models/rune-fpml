package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityOutstandingsPositionStatement;
import fpml.confirmation.validation.FacilityOutstandingsPositionStatementTypeFormatValidator;
import fpml.confirmation.validation.FacilityOutstandingsPositionStatementValidator;
import fpml.confirmation.validation.exists.FacilityOutstandingsPositionStatementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityOutstandingsPositionStatement.class)
public class FacilityOutstandingsPositionStatementMeta implements RosettaMetaData<FacilityOutstandingsPositionStatement> {

	@Override
	public List<Validator<? super FacilityOutstandingsPositionStatement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityOutstandingsPositionStatement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityOutstandingsPositionStatement> validator() {
		return new FacilityOutstandingsPositionStatementValidator();
	}

	@Override
	public Validator<? super FacilityOutstandingsPositionStatement> typeFormatValidator() {
		return new FacilityOutstandingsPositionStatementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityOutstandingsPositionStatement, Set<String>> onlyExistsValidator() {
		return new FacilityOutstandingsPositionStatementOnlyExistsValidator();
	}
}
