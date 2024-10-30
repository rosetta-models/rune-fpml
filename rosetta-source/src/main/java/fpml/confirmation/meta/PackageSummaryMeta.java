package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PackageSummary;
import fpml.confirmation.validation.PackageSummaryTypeFormatValidator;
import fpml.confirmation.validation.PackageSummaryValidator;
import fpml.confirmation.validation.exists.PackageSummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PackageSummary.class)
public class PackageSummaryMeta implements RosettaMetaData<PackageSummary> {

	@Override
	public List<Validator<? super PackageSummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PackageSummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PackageSummary> validator() {
		return new PackageSummaryValidator();
	}

	@Override
	public Validator<? super PackageSummary> typeFormatValidator() {
		return new PackageSummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PackageSummary, Set<String>> onlyExistsValidator() {
		return new PackageSummaryOnlyExistsValidator();
	}
}
