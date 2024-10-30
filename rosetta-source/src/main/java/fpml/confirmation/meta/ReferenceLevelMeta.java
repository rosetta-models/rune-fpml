package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReferenceLevel;
import fpml.confirmation.validation.ReferenceLevelTypeFormatValidator;
import fpml.confirmation.validation.ReferenceLevelValidator;
import fpml.confirmation.validation.exists.ReferenceLevelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ReferenceLevel.class)
public class ReferenceLevelMeta implements RosettaMetaData<ReferenceLevel> {

	@Override
	public List<Validator<? super ReferenceLevel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReferenceLevel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReferenceLevel> validator() {
		return new ReferenceLevelValidator();
	}

	@Override
	public Validator<? super ReferenceLevel> typeFormatValidator() {
		return new ReferenceLevelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferenceLevel, Set<String>> onlyExistsValidator() {
		return new ReferenceLevelOnlyExistsValidator();
	}
}
