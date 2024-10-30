package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ConvertibleBond;
import fpml.confirmation.validation.ConvertibleBondTypeFormatValidator;
import fpml.confirmation.validation.ConvertibleBondValidator;
import fpml.confirmation.validation.exists.ConvertibleBondOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ConvertibleBond.class)
public class ConvertibleBondMeta implements RosettaMetaData<ConvertibleBond> {

	@Override
	public List<Validator<? super ConvertibleBond>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ConvertibleBond, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ConvertibleBond> validator() {
		return new ConvertibleBondValidator();
	}

	@Override
	public Validator<? super ConvertibleBond> typeFormatValidator() {
		return new ConvertibleBondTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConvertibleBond, Set<String>> onlyExistsValidator() {
		return new ConvertibleBondOnlyExistsValidator();
	}
}
