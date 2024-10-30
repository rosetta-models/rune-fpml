package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOffset;
import fpml.confirmation.validation.AdjustableOffsetTypeFormatValidator;
import fpml.confirmation.validation.AdjustableOffsetValidator;
import fpml.confirmation.validation.exists.AdjustableOffsetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AdjustableOffset.class)
public class AdjustableOffsetMeta implements RosettaMetaData<AdjustableOffset> {

	@Override
	public List<Validator<? super AdjustableOffset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdjustableOffset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AdjustableOffset> validator() {
		return new AdjustableOffsetValidator();
	}

	@Override
	public Validator<? super AdjustableOffset> typeFormatValidator() {
		return new AdjustableOffsetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableOffset, Set<String>> onlyExistsValidator() {
		return new AdjustableOffsetOnlyExistsValidator();
	}
}
