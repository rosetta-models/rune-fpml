package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DealSummary;
import fpml.confirmation.validation.DealSummaryTypeFormatValidator;
import fpml.confirmation.validation.DealSummaryValidator;
import fpml.confirmation.validation.exists.DealSummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DealSummary.class)
public class DealSummaryMeta implements RosettaMetaData<DealSummary> {

	@Override
	public List<Validator<? super DealSummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.DealSummary>create(fpml.confirmation.validation.datarule.DealSummaryChoice.class)
		);
	}
	
	@Override
	public List<Function<? super DealSummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DealSummary> validator() {
		return new DealSummaryValidator();
	}

	@Override
	public Validator<? super DealSummary> typeFormatValidator() {
		return new DealSummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DealSummary, Set<String>> onlyExistsValidator() {
		return new DealSummaryOnlyExistsValidator();
	}
}
