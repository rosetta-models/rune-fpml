package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CompressionType;
import fpml.confirmation.validation.CompressionTypeTypeFormatValidator;
import fpml.confirmation.validation.CompressionTypeValidator;
import fpml.confirmation.validation.exists.CompressionTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CompressionType.class)
public class CompressionTypeMeta implements RosettaMetaData<CompressionType> {

	@Override
	public List<Validator<? super CompressionType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CompressionType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CompressionType> validator() {
		return new CompressionTypeValidator();
	}

	@Override
	public Validator<? super CompressionType> typeFormatValidator() {
		return new CompressionTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CompressionType, Set<String>> onlyExistsValidator() {
		return new CompressionTypeOnlyExistsValidator();
	}
}
