package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.validation.IdentifiedDateTypeFormatValidator;
import fpml.confirmation.validation.IdentifiedDateValidator;
import fpml.confirmation.validation.exists.IdentifiedDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=IdentifiedDate.class)
public class IdentifiedDateMeta implements RosettaMetaData<IdentifiedDate> {

	@Override
	public List<Validator<? super IdentifiedDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IdentifiedDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IdentifiedDate> validator() {
		return new IdentifiedDateValidator();
	}

	@Override
	public Validator<? super IdentifiedDate> typeFormatValidator() {
		return new IdentifiedDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IdentifiedDate, Set<String>> onlyExistsValidator() {
		return new IdentifiedDateOnlyExistsValidator();
	}
}
