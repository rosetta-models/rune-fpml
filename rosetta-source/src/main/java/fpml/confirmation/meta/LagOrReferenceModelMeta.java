package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LagOrReferenceModel;
import fpml.confirmation.validation.LagOrReferenceModelTypeFormatValidator;
import fpml.confirmation.validation.LagOrReferenceModelValidator;
import fpml.confirmation.validation.exists.LagOrReferenceModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LagOrReferenceModel.class)
public class LagOrReferenceModelMeta implements RosettaMetaData<LagOrReferenceModel> {

	@Override
	public List<Validator<? super LagOrReferenceModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.LagOrReferenceModel>create(fpml.confirmation.validation.datarule.LagOrReferenceModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LagOrReferenceModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LagOrReferenceModel> validator() {
		return new LagOrReferenceModelValidator();
	}

	@Override
	public Validator<? super LagOrReferenceModel> typeFormatValidator() {
		return new LagOrReferenceModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LagOrReferenceModel, Set<String>> onlyExistsValidator() {
		return new LagOrReferenceModelOnlyExistsValidator();
	}
}
