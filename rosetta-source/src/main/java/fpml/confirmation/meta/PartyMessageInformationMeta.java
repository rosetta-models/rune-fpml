package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyMessageInformation;
import fpml.confirmation.validation.PartyMessageInformationTypeFormatValidator;
import fpml.confirmation.validation.PartyMessageInformationValidator;
import fpml.confirmation.validation.exists.PartyMessageInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PartyMessageInformation.class)
public class PartyMessageInformationMeta implements RosettaMetaData<PartyMessageInformation> {

	@Override
	public List<Validator<? super PartyMessageInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyMessageInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyMessageInformation> validator() {
		return new PartyMessageInformationValidator();
	}

	@Override
	public Validator<? super PartyMessageInformation> typeFormatValidator() {
		return new PartyMessageInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyMessageInformation, Set<String>> onlyExistsValidator() {
		return new PartyMessageInformationOnlyExistsValidator();
	}
}
