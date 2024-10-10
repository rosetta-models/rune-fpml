package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MatrixSource;
import fpml.confirmation.validation.MatrixSourceTypeFormatValidator;
import fpml.confirmation.validation.MatrixSourceValidator;
import fpml.confirmation.validation.exists.MatrixSourceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MatrixSource.class)
public class MatrixSourceMeta implements RosettaMetaData<MatrixSource> {

	@Override
	public List<Validator<? super MatrixSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MatrixSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MatrixSource> validator() {
		return new MatrixSourceValidator();
	}

	@Override
	public Validator<? super MatrixSource> typeFormatValidator() {
		return new MatrixSourceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MatrixSource, Set<String>> onlyExistsValidator() {
		return new MatrixSourceOnlyExistsValidator();
	}
}
