package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LegId;
import fpml.confirmation.validation.LegIdTypeFormatValidator;
import fpml.confirmation.validation.LegIdValidator;
import fpml.confirmation.validation.exists.LegIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LegId.class)
public class LegIdMeta implements RosettaMetaData<LegId> {

	@Override
	public List<Validator<? super LegId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LegId> validator() {
		return new LegIdValidator();
	}

	@Override
	public Validator<? super LegId> typeFormatValidator() {
		return new LegIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegId, Set<String>> onlyExistsValidator() {
		return new LegIdOnlyExistsValidator();
	}
}
