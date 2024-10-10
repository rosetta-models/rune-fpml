package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MaturityChange;
import fpml.confirmation.validation.MaturityChangeTypeFormatValidator;
import fpml.confirmation.validation.MaturityChangeValidator;
import fpml.confirmation.validation.exists.MaturityChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MaturityChange.class)
public class MaturityChangeMeta implements RosettaMetaData<MaturityChange> {

	@Override
	public List<Validator<? super MaturityChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MaturityChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MaturityChange> validator() {
		return new MaturityChangeValidator();
	}

	@Override
	public Validator<? super MaturityChange> typeFormatValidator() {
		return new MaturityChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MaturityChange, Set<String>> onlyExistsValidator() {
		return new MaturityChangeOnlyExistsValidator();
	}
}
