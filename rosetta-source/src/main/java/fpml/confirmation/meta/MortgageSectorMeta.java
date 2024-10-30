package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MortgageSector;
import fpml.confirmation.validation.MortgageSectorTypeFormatValidator;
import fpml.confirmation.validation.MortgageSectorValidator;
import fpml.confirmation.validation.exists.MortgageSectorOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MortgageSector.class)
public class MortgageSectorMeta implements RosettaMetaData<MortgageSector> {

	@Override
	public List<Validator<? super MortgageSector>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MortgageSector, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MortgageSector> validator() {
		return new MortgageSectorValidator();
	}

	@Override
	public Validator<? super MortgageSector> typeFormatValidator() {
		return new MortgageSectorTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MortgageSector, Set<String>> onlyExistsValidator() {
		return new MortgageSectorOnlyExistsValidator();
	}
}
