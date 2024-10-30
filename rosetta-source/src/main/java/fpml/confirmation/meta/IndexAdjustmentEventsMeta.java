package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IndexAdjustmentEvents;
import fpml.confirmation.validation.IndexAdjustmentEventsTypeFormatValidator;
import fpml.confirmation.validation.IndexAdjustmentEventsValidator;
import fpml.confirmation.validation.exists.IndexAdjustmentEventsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=IndexAdjustmentEvents.class)
public class IndexAdjustmentEventsMeta implements RosettaMetaData<IndexAdjustmentEvents> {

	@Override
	public List<Validator<? super IndexAdjustmentEvents>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IndexAdjustmentEvents, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IndexAdjustmentEvents> validator() {
		return new IndexAdjustmentEventsValidator();
	}

	@Override
	public Validator<? super IndexAdjustmentEvents> typeFormatValidator() {
		return new IndexAdjustmentEventsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndexAdjustmentEvents, Set<String>> onlyExistsValidator() {
		return new IndexAdjustmentEventsOnlyExistsValidator();
	}
}
