package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilitySummary;
import fpml.confirmation.validation.FacilitySummaryTypeFormatValidator;
import fpml.confirmation.validation.FacilitySummaryValidator;
import fpml.confirmation.validation.exists.FacilitySummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilitySummary.class)
public class FacilitySummaryMeta implements RosettaMetaData<FacilitySummary> {

	@Override
	public List<Validator<? super FacilitySummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilitySummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilitySummary> validator() {
		return new FacilitySummaryValidator();
	}

	@Override
	public Validator<? super FacilitySummary> typeFormatValidator() {
		return new FacilitySummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilitySummary, Set<String>> onlyExistsValidator() {
		return new FacilitySummaryOnlyExistsValidator();
	}
}
