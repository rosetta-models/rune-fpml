package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OrganizationType;
import fpml.confirmation.validation.OrganizationTypeTypeFormatValidator;
import fpml.confirmation.validation.OrganizationTypeValidator;
import fpml.confirmation.validation.exists.OrganizationTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OrganizationType.class)
public class OrganizationTypeMeta implements RosettaMetaData<OrganizationType> {

	@Override
	public List<Validator<? super OrganizationType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OrganizationType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OrganizationType> validator() {
		return new OrganizationTypeValidator();
	}

	@Override
	public Validator<? super OrganizationType> typeFormatValidator() {
		return new OrganizationTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OrganizationType, Set<String>> onlyExistsValidator() {
		return new OrganizationTypeOnlyExistsValidator();
	}
}
