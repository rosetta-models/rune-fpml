package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustedRelativeDateOffset;
import fpml.confirmation.validation.AdjustedRelativeDateOffsetTypeFormatValidator;
import fpml.confirmation.validation.AdjustedRelativeDateOffsetValidator;
import fpml.confirmation.validation.exists.AdjustedRelativeDateOffsetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AdjustedRelativeDateOffset.class)
public class AdjustedRelativeDateOffsetMeta implements RosettaMetaData<AdjustedRelativeDateOffset> {

	@Override
	public List<Validator<? super AdjustedRelativeDateOffset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdjustedRelativeDateOffset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AdjustedRelativeDateOffset> validator() {
		return new AdjustedRelativeDateOffsetValidator();
	}

	@Override
	public Validator<? super AdjustedRelativeDateOffset> typeFormatValidator() {
		return new AdjustedRelativeDateOffsetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustedRelativeDateOffset, Set<String>> onlyExistsValidator() {
		return new AdjustedRelativeDateOffsetOnlyExistsValidator();
	}
}
