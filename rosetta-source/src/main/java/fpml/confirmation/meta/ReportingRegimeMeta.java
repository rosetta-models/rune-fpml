package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReportingRegime;
import fpml.confirmation.validation.ReportingRegimeTypeFormatValidator;
import fpml.confirmation.validation.ReportingRegimeValidator;
import fpml.confirmation.validation.exists.ReportingRegimeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ReportingRegime.class)
public class ReportingRegimeMeta implements RosettaMetaData<ReportingRegime> {

	@Override
	public List<Validator<? super ReportingRegime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ReportingRegime>create(fpml.confirmation.validation.datarule.ReportingRegimeChoice0.class),
			factory.<fpml.confirmation.ReportingRegime>create(fpml.confirmation.validation.datarule.ReportingRegimeChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super ReportingRegime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReportingRegime> validator() {
		return new ReportingRegimeValidator();
	}

	@Override
	public Validator<? super ReportingRegime> typeFormatValidator() {
		return new ReportingRegimeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingRegime, Set<String>> onlyExistsValidator() {
		return new ReportingRegimeOnlyExistsValidator();
	}
}
