package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.VolatilityMatrix;
import fpml.confirmation.validation.VolatilityMatrixTypeFormatValidator;
import fpml.confirmation.validation.VolatilityMatrixValidator;
import fpml.confirmation.validation.exists.VolatilityMatrixOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=VolatilityMatrix.class)
public class VolatilityMatrixMeta implements RosettaMetaData<VolatilityMatrix> {

	@Override
	public List<Validator<? super VolatilityMatrix>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VolatilityMatrix, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VolatilityMatrix> validator() {
		return new VolatilityMatrixValidator();
	}

	@Override
	public Validator<? super VolatilityMatrix> typeFormatValidator() {
		return new VolatilityMatrixTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VolatilityMatrix, Set<String>> onlyExistsValidator() {
		return new VolatilityMatrixOnlyExistsValidator();
	}
}
