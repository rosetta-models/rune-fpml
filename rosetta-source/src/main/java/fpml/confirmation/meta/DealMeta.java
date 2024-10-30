package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Deal;
import fpml.confirmation.validation.DealTypeFormatValidator;
import fpml.confirmation.validation.DealValidator;
import fpml.confirmation.validation.exists.DealOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Deal.class)
public class DealMeta implements RosettaMetaData<Deal> {

	@Override
	public List<Validator<? super Deal>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.DealSummary>create(fpml.confirmation.validation.datarule.DealSummaryChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Deal, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Deal> validator() {
		return new DealValidator();
	}

	@Override
	public Validator<? super Deal> typeFormatValidator() {
		return new DealTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Deal, Set<String>> onlyExistsValidator() {
		return new DealOnlyExistsValidator();
	}
}
