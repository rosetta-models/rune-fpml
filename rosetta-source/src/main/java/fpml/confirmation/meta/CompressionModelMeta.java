package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CompressionModel;
import fpml.confirmation.validation.CompressionModelTypeFormatValidator;
import fpml.confirmation.validation.CompressionModelValidator;
import fpml.confirmation.validation.exists.CompressionModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CompressionModel.class)
public class CompressionModelMeta implements RosettaMetaData<CompressionModel> {

	@Override
	public List<Validator<? super CompressionModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CompressionModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CompressionModel> validator() {
		return new CompressionModelValidator();
	}

	@Override
	public Validator<? super CompressionModel> typeFormatValidator() {
		return new CompressionModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CompressionModel, Set<String>> onlyExistsValidator() {
		return new CompressionModelOnlyExistsValidator();
	}
}
