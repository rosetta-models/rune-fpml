package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDatesOrRelativeDateOffset;
import fpml.confirmation.validation.AdjustableDatesOrRelativeDateOffsetTypeFormatValidator;
import fpml.confirmation.validation.AdjustableDatesOrRelativeDateOffsetValidator;
import fpml.confirmation.validation.exists.AdjustableDatesOrRelativeDateOffsetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AdjustableDatesOrRelativeDateOffset.class)
public class AdjustableDatesOrRelativeDateOffsetMeta implements RosettaMetaData<AdjustableDatesOrRelativeDateOffset> {

	@Override
	public List<Validator<? super AdjustableDatesOrRelativeDateOffset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.AdjustableDatesOrRelativeDateOffset>create(fpml.confirmation.validation.datarule.AdjustableDatesOrRelativeDateOffsetChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AdjustableDatesOrRelativeDateOffset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AdjustableDatesOrRelativeDateOffset> validator() {
		return new AdjustableDatesOrRelativeDateOffsetValidator();
	}

	@Override
	public Validator<? super AdjustableDatesOrRelativeDateOffset> typeFormatValidator() {
		return new AdjustableDatesOrRelativeDateOffsetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableDatesOrRelativeDateOffset, Set<String>> onlyExistsValidator() {
		return new AdjustableDatesOrRelativeDateOffsetOnlyExistsValidator();
	}
}
