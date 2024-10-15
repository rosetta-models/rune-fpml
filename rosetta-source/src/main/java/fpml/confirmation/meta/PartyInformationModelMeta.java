package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyInformationModel;
import fpml.confirmation.validation.PartyInformationModelTypeFormatValidator;
import fpml.confirmation.validation.PartyInformationModelValidator;
import fpml.confirmation.validation.exists.PartyInformationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PartyInformationModel.class)
public class PartyInformationModelMeta implements RosettaMetaData<PartyInformationModel> {

	@Override
	public List<Validator<? super PartyInformationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyInformationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyInformationModel> validator() {
		return new PartyInformationModelValidator();
	}

	@Override
	public Validator<? super PartyInformationModel> typeFormatValidator() {
		return new PartyInformationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyInformationModel, Set<String>> onlyExistsValidator() {
		return new PartyInformationModelOnlyExistsValidator();
	}
}
