package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LcEventGroup;
import fpml.confirmation.validation.LcEventGroupTypeFormatValidator;
import fpml.confirmation.validation.LcEventGroupValidator;
import fpml.confirmation.validation.exists.LcEventGroupOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LcEventGroup.class)
public class LcEventGroupMeta implements RosettaMetaData<LcEventGroup> {

	@Override
	public List<Validator<? super LcEventGroup>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcEventGroup, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LcEventGroup> validator() {
		return new LcEventGroupValidator();
	}

	@Override
	public Validator<? super LcEventGroup> typeFormatValidator() {
		return new LcEventGroupTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcEventGroup, Set<String>> onlyExistsValidator() {
		return new LcEventGroupOnlyExistsValidator();
	}
}
