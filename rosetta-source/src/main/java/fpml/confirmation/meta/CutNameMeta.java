package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CutName;
import fpml.confirmation.validation.CutNameTypeFormatValidator;
import fpml.confirmation.validation.CutNameValidator;
import fpml.confirmation.validation.exists.CutNameOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CutName.class)
public class CutNameMeta implements RosettaMetaData<CutName> {

	@Override
	public List<Validator<? super CutName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CutName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CutName> validator() {
		return new CutNameValidator();
	}

	@Override
	public Validator<? super CutName> typeFormatValidator() {
		return new CutNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CutName, Set<String>> onlyExistsValidator() {
		return new CutNameOnlyExistsValidator();
	}
}
