package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReportingRole;
import fpml.confirmation.validation.ReportingRoleTypeFormatValidator;
import fpml.confirmation.validation.ReportingRoleValidator;
import fpml.confirmation.validation.exists.ReportingRoleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ReportingRole.class)
public class ReportingRoleMeta implements RosettaMetaData<ReportingRole> {

	@Override
	public List<Validator<? super ReportingRole>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportingRole, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReportingRole> validator() {
		return new ReportingRoleValidator();
	}

	@Override
	public Validator<? super ReportingRole> typeFormatValidator() {
		return new ReportingRoleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingRole, Set<String>> onlyExistsValidator() {
		return new ReportingRoleOnlyExistsValidator();
	}
}
