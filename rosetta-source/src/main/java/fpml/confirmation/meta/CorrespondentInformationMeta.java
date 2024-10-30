package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CorrespondentInformation;
import fpml.confirmation.validation.CorrespondentInformationTypeFormatValidator;
import fpml.confirmation.validation.CorrespondentInformationValidator;
import fpml.confirmation.validation.exists.CorrespondentInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CorrespondentInformation.class)
public class CorrespondentInformationMeta implements RosettaMetaData<CorrespondentInformation> {

	@Override
	public List<Validator<? super CorrespondentInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CorrespondentInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CorrespondentInformation> validator() {
		return new CorrespondentInformationValidator();
	}

	@Override
	public Validator<? super CorrespondentInformation> typeFormatValidator() {
		return new CorrespondentInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CorrespondentInformation, Set<String>> onlyExistsValidator() {
		return new CorrespondentInformationOnlyExistsValidator();
	}
}
