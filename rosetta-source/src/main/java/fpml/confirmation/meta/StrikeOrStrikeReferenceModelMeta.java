package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.StrikeOrStrikeReferenceModel;
import fpml.confirmation.validation.StrikeOrStrikeReferenceModelTypeFormatValidator;
import fpml.confirmation.validation.StrikeOrStrikeReferenceModelValidator;
import fpml.confirmation.validation.exists.StrikeOrStrikeReferenceModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=StrikeOrStrikeReferenceModel.class)
public class StrikeOrStrikeReferenceModelMeta implements RosettaMetaData<StrikeOrStrikeReferenceModel> {

	@Override
	public List<Validator<? super StrikeOrStrikeReferenceModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.StrikeOrStrikeReferenceModel>create(fpml.confirmation.validation.datarule.StrikeOrStrikeReferenceModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super StrikeOrStrikeReferenceModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super StrikeOrStrikeReferenceModel> validator() {
		return new StrikeOrStrikeReferenceModelValidator();
	}

	@Override
	public Validator<? super StrikeOrStrikeReferenceModel> typeFormatValidator() {
		return new StrikeOrStrikeReferenceModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StrikeOrStrikeReferenceModel, Set<String>> onlyExistsValidator() {
		return new StrikeOrStrikeReferenceModelOnlyExistsValidator();
	}
}
