package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeReferenceInformationModel;
import fpml.confirmation.validation.TradeReferenceInformationModelTypeFormatValidator;
import fpml.confirmation.validation.TradeReferenceInformationModelValidator;
import fpml.confirmation.validation.exists.TradeReferenceInformationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeReferenceInformationModel.class)
public class TradeReferenceInformationModelMeta implements RosettaMetaData<TradeReferenceInformationModel> {

	@Override
	public List<Validator<? super TradeReferenceInformationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeReferenceInformationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeReferenceInformationModel> validator() {
		return new TradeReferenceInformationModelValidator();
	}

	@Override
	public Validator<? super TradeReferenceInformationModel> typeFormatValidator() {
		return new TradeReferenceInformationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeReferenceInformationModel, Set<String>> onlyExistsValidator() {
		return new TradeReferenceInformationModelOnlyExistsValidator();
	}
}
