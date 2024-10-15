package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReportingRegimeIdentifier;
import fpml.confirmation.validation.ReportingRegimeIdentifierTypeFormatValidator;
import fpml.confirmation.validation.ReportingRegimeIdentifierValidator;
import fpml.confirmation.validation.exists.ReportingRegimeIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReportingRegimeIdentifier.class)
public class ReportingRegimeIdentifierMeta implements RosettaMetaData<ReportingRegimeIdentifier> {

	@Override
	public List<Validator<? super ReportingRegimeIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ReportingRegimeIdentifier>create(fpml.confirmation.validation.datarule.ReportingRegimeIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ReportingRegimeIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReportingRegimeIdentifier> validator() {
		return new ReportingRegimeIdentifierValidator();
	}

	@Override
	public Validator<? super ReportingRegimeIdentifier> typeFormatValidator() {
		return new ReportingRegimeIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingRegimeIdentifier, Set<String>> onlyExistsValidator() {
		return new ReportingRegimeIdentifierOnlyExistsValidator();
	}
}
